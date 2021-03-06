package org.apache.lucene.codecs;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Closeable;
import java.io.IOException;

import org.apache.lucene.index.DimensionalValues;
import org.apache.lucene.util.Accountable;

/** Abstract API to visit dimensional values.
 *
 * @lucene.experimental
 */
public abstract class DimensionalReader extends DimensionalValues implements Closeable, Accountable {

  /** Sole constructor. (For invocation by subclass constructors, typically implicit.) */
  protected DimensionalReader() {}

  /** 
   * Checks consistency of this reader.
   * <p>
   * Note that this may be costly in terms of I/O, e.g. 
   * may involve computing a checksum value against large data files.
   * @lucene.internal
   */
  public abstract void checkIntegrity() throws IOException;

  /** 
   * Returns an instance optimized for merging.
   * <p>
   * The default implementation returns {@code this} */
  public DimensionalReader getMergeInstance() throws IOException {
    return this;
  }
}
