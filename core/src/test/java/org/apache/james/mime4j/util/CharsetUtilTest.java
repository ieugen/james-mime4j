/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.mime4j.util;

import java.nio.charset.Charset;

import junit.framework.TestCase;

public class CharsetUtilTest extends TestCase {

    private static final String SWISS_GERMAN_HELLO = "Gr\374ezi_z\344m\344";
    private static final String RUSSIAN_HELLO = "\u0412\u0441\u0435\u043C_\u043F\u0440\u0438\u0432\u0435\u0442";

    public void testAllASCII() {
        String s = "Like hello and stuff";
        assertTrue(CharsetUtil.isASCII(s));
    }

    public void testNonASCII() {
        assertFalse(CharsetUtil.isASCII(SWISS_GERMAN_HELLO));
        assertFalse(CharsetUtil.isASCII(RUSSIAN_HELLO));
    }

    public void testCharsetLookup() {
        Charset c1 = CharsetUtil.lookup("us-ascii");
        Charset c2 = CharsetUtil.lookup("ascii");
        assertEquals(CharsetUtil.US_ASCII, c1);
        assertEquals(CharsetUtil.US_ASCII, c2);
    }

    public void testCharsetLookupNullInput() {
        Charset c1 = CharsetUtil.lookup(null);
        assertNull(c1);
    }

    public void testCharsetLookupFailure() {
        Charset c1 = CharsetUtil.lookup("whatever");
        assertNull(c1);
    }

}
