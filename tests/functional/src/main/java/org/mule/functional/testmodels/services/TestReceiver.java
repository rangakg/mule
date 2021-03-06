/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.functional.testmodels.services;

import static java.lang.Thread.currentThread;
import static org.mule.runtime.core.api.Event.getCurrentEvent;

import org.mule.runtime.api.exception.MuleException;
import org.mule.runtime.api.message.Message;
import org.mule.runtime.core.api.DefaultMuleException;
import org.mule.runtime.core.api.Event;
import org.mule.runtime.core.api.MuleContext;
import org.mule.runtime.core.api.context.MuleContextAware;
import org.mule.runtime.core.api.processor.Processor;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestReceiver implements Processor, MuleContextAware {

  protected static final Logger logger = LoggerFactory.getLogger(TestReceiver.class);

  private MuleContext muleContext;

  protected AtomicInteger count = new AtomicInteger(0);

  @Override
  public Event process(Event event) throws MuleException {
    try {
      final Message message = event.getMessage();
      return Event.builder(event)
          .message(Message.builder(message).payload(receive(event.getMessageAsString(muleContext))).build())
          .build();
    } catch (Exception e) {
      throw new DefaultMuleException(e);
    }
  }

  public String receive(String message) throws Exception {
    if (logger.isDebugEnabled()) {
      logger.debug("Received: " + message + " Number: " + inc() + " in thread: " + currentThread().getName());
      logger.debug("Message ID is: " + getCurrentEvent().getCorrelationId());
    }

    return "Received: " + message;
  }

  protected int inc() {
    return count.incrementAndGet();
  }

  @Override
  public void setMuleContext(MuleContext muleContext) {
    this.muleContext = muleContext;
  }
}
