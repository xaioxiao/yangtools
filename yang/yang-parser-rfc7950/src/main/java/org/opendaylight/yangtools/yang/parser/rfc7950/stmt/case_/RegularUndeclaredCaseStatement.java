/*
 * Copyright (c) 2020 PANTHEON.tech, s.r.o. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.yangtools.yang.parser.rfc7950.stmt.case_;

import com.google.common.collect.ImmutableList;
import org.opendaylight.yangtools.yang.common.QName;
import org.opendaylight.yangtools.yang.model.api.meta.DeclaredStatement;
import org.opendaylight.yangtools.yang.model.api.meta.StatementSource;

final class RegularUndeclaredCaseStatement extends RegularCaseStatement {
    RegularUndeclaredCaseStatement(final QName argument,
            final ImmutableList<? extends DeclaredStatement<?>> substatements) {
        super(argument, substatements);
    }

    @Override
    public StatementSource getStatementSource() {
        return StatementSource.CONTEXT;
    }
}
