/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.module.extension.internal.resources;

import static org.mule.runtime.core.api.config.MuleManifest.getProductVersion;
import org.mule.runtime.api.meta.model.ExtensionModel;

/**
 * Utility class to access the {@link ExtensionModel} definition for Mule's Runtime
 *
 * @since 4.0
 */
public class MuleExtensionModelProvider {

  public static final String MULE_NAME = "Mule Core";
  public static final String MULE_VERSION = getProductVersion();
  private static final String MODEL_JSON = "META-INF/mule-extension-model.json";
  // private static final ExtensionModel EXTENSION_MODEL =
  //     withContextClassLoader(ExtensionTypeAnnotationsRegistry.class.getClassLoader(),
  //                            () -> new ExtensionModelJsonSerializer(false)
  //                                .deserialize(IOUtils.toString(MuleExtensionModelProvider.class.getClassLoader()
  //                                    .getResourceAsStream(MODEL_JSON))));

  /**
   * @return the {@link ExtensionModel} definition for Mule's Runtime
   */
  public static ExtensionModel getExtensionModel() {
    return null;
  }
}
