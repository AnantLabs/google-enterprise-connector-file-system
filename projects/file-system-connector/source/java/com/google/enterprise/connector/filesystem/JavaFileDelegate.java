// Copyright 2012 Google Inc.
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

package com.google.enterprise.connector.filesystem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * An implementation of {@link FileDelegate} that wraps {@code java.io.File}.
 */
public class JavaFileDelegate extends File implements FileDelegate {

  public JavaFileDelegate(String path) {
    super(path);
  }

  public JavaFileDelegate(File f, String name) {
    super(f, name);
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return new BufferedInputStream(new FileInputStream(this));
  }
}
