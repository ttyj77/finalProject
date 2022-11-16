
function createToken() {
    toekn = sessionStorage.getItem("wtw-token")
    fetch("/api/token", {
        method: "GET",
        headers: {
            "Content-type": "application/json",
            "Authorization": toekn
        },

    })
    //   console.log(headers.getItem(Authorization))
}

// (function () {

//     "use strict";


//     window.onload = function () {
//         toekn = sessionStorage.getItem("wtw-token")
//         fetch("/api/token", {
//             method: "GET",
//             headers: {
//                 "Content-type": "application/json",
//                 "Authorization": toekn
//             },

//         })
//     }

// })();