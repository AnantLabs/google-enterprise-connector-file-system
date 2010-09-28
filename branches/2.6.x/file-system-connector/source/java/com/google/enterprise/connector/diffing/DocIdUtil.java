// Copyright 2010 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.enterprise.connector.diffing;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Static methods to convert paths to doc-ids and vice-versa.
 * Raison d'Etre: CM puts doc ids into URLs without encoding them and
 * FileConnector URLs have "special" characters.
 */
public class DocIdUtil {
  private static final String UTF_8 = "UTF-8";

  private DocIdUtil() {
  }

  public static String pathToId(String path) {
    try {
      return URLEncoder.encode(path, UTF_8);
    } catch (java.io.UnsupportedEncodingException e) {
      throw new RuntimeException("No UTF-8 support on system.", e);
    }
  }

  public static String idToPath(String id) {
    try {
      return URLDecoder.decode(id, UTF_8);
    } catch (java.io.UnsupportedEncodingException e) {
      throw new RuntimeException("No UTF-8 support on system.", e);
    }
  }
}
