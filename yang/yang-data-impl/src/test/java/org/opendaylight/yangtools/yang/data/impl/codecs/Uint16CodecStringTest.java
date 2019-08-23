/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.data.impl.codecs;

import static org.junit.Assert.assertEquals;
import static org.opendaylight.yangtools.yang.data.impl.codecs.TypeDefinitionAwareCodecTestHelper.deserializeWithExpectedIllegalArgEx;
import static org.opendaylight.yangtools.yang.data.impl.codecs.TypeDefinitionAwareCodecTestHelper.getCodec;

import org.junit.Test;
import org.opendaylight.yangtools.yang.common.Uint16;
import org.opendaylight.yangtools.yang.data.api.codec.Uint16Codec;
import org.opendaylight.yangtools.yang.model.util.type.BaseTypes;

/**
 * Unit tests for Uint16CodecString.
 *
 * @author Thomas Pantelis
 */
public class Uint16CodecStringTest {
    @SuppressWarnings("unchecked")
    @Test
    public void testSerialize() {
        Uint16Codec<String> codec = getCodec(BaseTypes.uint16Type(), Uint16Codec.class);
        assertEquals("10", codec.serialize(Uint16.valueOf(10)));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testDeserialize() {
        final String hexa = "0X45c";
        final String octal = "02134";
        final String integer = "1116";

        Uint16Codec<String> codec = getCodec(BaseTypes.uint16Type(), Uint16Codec.class);

        assertEquals(Uint16.valueOf("045c", 16), codec.deserialize(hexa));
        assertEquals(Uint16.valueOf(octal, 8), codec.deserialize(octal));
        assertEquals(Uint16.valueOf(integer, 10), codec.deserialize(integer));

        deserializeWithExpectedIllegalArgEx(codec, "1o");
        deserializeWithExpectedIllegalArgEx(codec, "");
    }
}
