/**
 * Copyright (c) 2009-2014, Data Geekery GmbH (http://www.datageekery.com)
 * All rights reserved.
 *
 * This work is dual-licensed
 * - under the Apache Software License 2.0 (the "ASL")
 * - under the jOOQ License and Maintenance Agreement (the "jOOQ License")
 * =============================================================================
 * You may choose which license applies to you:
 *
 * - If you're using this work with Open Source databases, you may choose
 *   either ASL or jOOQ License.
 * - If you're using this work with at least one commercial database, you must
 *   choose jOOQ License
 *
 * For more information, please visit http://www.jooq.org/licenses
 *
 * Apache Software License 2.0:
 * -----------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * jOOQ License and Maintenance Agreement:
 * -----------------------------------------------------------------------------
 * Data Geekery grants the Customer the non-exclusive, timely limited and
 * non-transferable license to install and use the Software under the terms of
 * the jOOQ License and Maintenance Agreement.
 *
 * This library is distributed with a LIMITED WARRANTY. See the jOOQ License
 * and Maintenance Agreement for more details: http://www.jooq.org/licensing
 */
package org.jooq;

import java.util.Map;

import org.jooq.conf.Settings;

/**
 * Scope implementations provide access to a variety of objects that are
 * available from a given scope.
 * <p>
 * The scope of the various objects contained in this type (e.g.
 * {@link #configuration()}, {@link #settings()}, etc.) are implementation
 * dependent and will be specified by the concrete subtype of <code>Scope</code>.
 *
 * @author Lukas Eder
 */
public interface Scope {

    /**
     * The configuration of the current scope.
     */
    Configuration configuration();

    /**
     * The settings wrapped by this context.
     * <p>
     * This method is a convenient way of accessing
     * <code>configuration().settings()</code>.
     */
    Settings settings();

    /**
     * The {@link SQLDialect} wrapped by this context.
     * <p>
     * This method is a convenient way of accessing
     * <code>configuration().dialect()</code>.
     */
    SQLDialect dialect();

    /**
     * The {@link SQLDialect#family()} wrapped by this context.
     * <p>
     * This method is a convenient way of accessing
     * <code>configuration().dialect().family()</code>.
     */
    SQLDialect family();

    /**
     * Get all custom data from this <code>Scope</code>.
     * <p>
     * This is custom data that was previously set to the context using
     * {@link #data(Object, Object)}. Use custom data if you want to pass data
     * to {@link QueryPart} objects for a given {@link Scope}.
     *
     * @return The custom data. This is never <code>null</code>
     */
    Map<Object, Object> data();

    /**
     * Get some custom data from this <code>Scope</code>.
     * <p>
     * This is custom data that was previously set to the context using
     * {@link #data(Object, Object)}. Use custom data if you want to pass data
     * to {@link QueryPart} objects for a given {@link Scope}
     *
     * @param key A key to identify the custom data
     * @return The custom data or <code>null</code> if no such data is contained
     *         in this <code>Scope</code>
     */
    Object data(Object key);

    /**
     * Set some custom data to this <code>Scope</code>.
     * <p>
     * This is custom data that was previously set to the context using
     * {@link #data(Object, Object)}. Use custom data if you want to pass data
     * to {@link QueryPart} objects for a given {@link Scope}.
     *
     * @param key A key to identify the custom data
     * @param value The custom data
     * @return The previously set custom data or <code>null</code> if no data
     *         was previously set for the given key
     */
    Object data(Object key, Object value);
}
