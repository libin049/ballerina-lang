// Copyright (c) 2018 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 Inc. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import ballerina/io;
import ballerina/http;

listener http:MockListener mockEP  = new(9090);

@http:ServiceConfig {
    basePath:"/page",
    host:"abc.com"
}
service Host1 on mockEP {
    @http:ResourceConfig {
        path: "/index"
    }
    resource function productsInfo1(http:Caller caller, http:Request req) {
        http:Response res = new;
        json responseJson = { "echo": "abc.com" };
        res.setJsonPayload(responseJson);
        checkpanic caller->respond(res);
    }
}

@http:ServiceConfig {
    basePath:"/page",
    host:"xyz.org"
}
service Host2 on mockEP {
    @http:ResourceConfig {
        path: "/index"
    }
    resource function productsInfo1(http:Caller caller, http:Request req) {
        http:Response res = new;
        json responseJson = { "echo": "xyz.org" };
        res.setJsonPayload(responseJson);
        checkpanic caller->respond(res);
    }
}

@http:ServiceConfig {
    basePath:"/page"
}
service Host3 on mockEP {
    @http:ResourceConfig {
        path: "/index"
    }
    resource function productsInfo1(http:Caller caller, http:Request req) {
        http:Response res = new;
        json responseJson = { "echo": "no host" };
        res.setJsonPayload(responseJson);
        checkpanic caller->respond(res);
    }
}
