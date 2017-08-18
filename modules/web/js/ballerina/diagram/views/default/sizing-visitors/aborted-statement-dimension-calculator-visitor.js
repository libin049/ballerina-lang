/**
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
import { util } from './../sizing-utils';

/**
 * Dimension visitor class for aborted statement.
 *
 * @class AbortedStatementDimensionCalculatorVisitor
 * */
class AbortedStatementDimensionCalculatorVisitor {
    /**
     * can visit the visitor.
     *
     * @return {boolean} true
     *
     * @memberOf AbortedStatementDimensionCalculatorVisitor
     * */
    canVisit() {
        return true;
    }

    /**
     * begin visiting the visitor.
     *
     * @memberOf AbortedStatementDimensionCalculatorVisitor
     * */
    beginVisit() {
    }

    /**
     * visit the visitor
     *
     * @memberOf AbortedStatementDimensionCalculatorVisitor
     * */
    visit() {
    }

    /**
     * visit the visitor at the end.
     *
     * @param {ASTNode} node - Aborted Statement node.
     *
     * @memberOf AbortedStatementDimensionCalculatorVisitor
     * */
    endVisit(node) {
        util.populateCompoundStatementChild(node);

        // / Calculate the title width as to the keyword width.
        const viewState = node.getViewState();
        viewState.titleWidth = util.getTextWidth('Aborted').w;
    }
}

export default AbortedStatementDimensionCalculatorVisitor;
