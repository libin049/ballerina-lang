/*
 *  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.jvm.types;

/**
 * {@code BObjectType} represents a user defined object type in Ballerina.
 *
 * @since 0.995.0
 */
public class BObjectType extends BStructureType {

    private AttachedFunction[] attachedFunctions;
    public AttachedFunction initializer;
    public AttachedFunction defaultsValuesInitFunc;

    /**
     * Create a {@code BObjectType} which represents the user defined struct type.
     *
     * @param typeName string name of the type
     * @param pkgPath package of the struct
     * @param flags flags of the object type
     */
    public BObjectType(String typeName, String pkgPath, int flags) {
        super(typeName, pkgPath, flags, Object.class);
    }

    @Override
    public <V extends Object> V getZeroValue() {
        return null;
    }

    @Override
    public String getAnnotationKey() {
        return this.typeName;
    }

    @Override
    public <V extends Object> V getEmptyValue() {
        return null;
    }

    @Override
    public int getTag() {
        return TypeTags.OBJECT_TYPE_TAG;
    }

    public AttachedFunction[] getAttachedFunctions() {
        return attachedFunctions;
    }

    public void setAttachedFunctions(AttachedFunction[] attachedFunctions) {
        this.attachedFunctions = attachedFunctions;
    }

    public void setInitializer(AttachedFunction initializer) {
        this.initializer = initializer;
    }

    public String toString() {
        return (pkgPath == null || pkgPath.equals(".")) ? typeName : pkgPath + ":" + typeName;
    }
}
