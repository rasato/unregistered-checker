console.log("test");

function getURL(URL) {
    return new Promise(function (resolve, reject) {
        var req = new XMLHttpRequest();
        req.open('GET', URL, true);
        req.onload = function () {
            if (req.status === 200) {
                resolve(req.responseText);
            } else {
                reject(new Error(req.statusText));
            }
        };
        req.onerror = function () {
            reject(new Error(req.statusText));
        };
        req.send();
    });
}

var url = "http://localhost:8080/customers/ss"
var promise = getURL(url);
promise.then(function onFulfilled(value) {
    console.log("async call.");
    console.log(value);
}).catch(function onRejected(error) {
    console.log("async call.");
    console.error(error);
});
console.log("sync call.");