/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ballerinalang.stdlib.reflect.nativeimpl;

import org.ballerinalang.bre.Context;
import org.ballerinalang.jvm.Strand;
import org.ballerinalang.jvm.values.ArrayValue;
import org.ballerinalang.jvm.values.TypedescValue;
import org.ballerinalang.model.types.BStructureType;
import org.ballerinalang.model.values.BTypeDescValue;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.annotations.BallerinaFunction;

/**
 * Get struct's Annotations.
 *
 * @since 0.965.0
 */
@BallerinaFunction(
        orgName = "ballerina", packageName = "reflect",
        functionName = "getStructAnnotations"
)
public class GetStructAnnotations extends AbstractAnnotationReader {

    @Override
    public void execute(Context context) {
        BTypeDescValue bTypeValue = (BTypeDescValue) context.getRefArgument(0);
        if (!(bTypeValue.value() instanceof BStructureType)) {
            context.setReturnValues((BValue) null);
        }
        BStructureType structType = (BStructureType) bTypeValue.value();
        context.setReturnValues(getAnnotationValue(context, structType.getPackagePath(), structType.getName()));
    }

    public static ArrayValue getStructAnnotations(Strand strand, TypedescValue typeValue) {
        //TODO verify the use of typeValue.getDescribingType() instead of typeValue.getType()
        if (!(typeValue.getDescribingType() instanceof org.ballerinalang.jvm.types.BStructureType)) {
            return null;
        }
        org.ballerinalang.jvm.types.BStructureType structType =
                (org.ballerinalang.jvm.types.BStructureType) typeValue.getDescribingType();
        return getAnnotationValue(structType, structType.getName());
    }
}
