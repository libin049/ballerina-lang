import ballerina/http;

service serviceName on new http:Listener(8080) {
    resource function newResource(http:Caller caller, http:Request request) {
        f
    }
}
function function1(int a, string b) {
    int testVal = a;
}
function function2() returns (int){
    int testA = 1;
    int testB = 2;
    return testA;
}
function function4() {
    string testStr = "This is Test String";
}