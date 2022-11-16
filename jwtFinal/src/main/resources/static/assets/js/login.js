const username = document.getElementById("username"),
  password = document.getElementById("password")

const formData = document.getElementById("submit-form")

function login(event) {
  event.preventDefault()
  // const payload = new FormData(formData)
  const req = {
    username: username.value,
    password: password.value,
  }

  fetch("/login", {
    method: "POST",
    headers: {
      "Content-type": "application/json",
    },
    body: JSON.stringify(req),
  })
    .then((Response) => {
      Response.text()
      console.log("Authorization: ", Response.headers.get("Authorization"))
      const jwttoken = Response.headers.get("Authorization")
      sessionStorage.setItem("Authorization", jwttoken)
      // let config = {
      //   headers: {
      //     "access-token": jwttoken,
      //   },
      // }
      console.log(jwttoken)
    })
    .then((req) => {
      console.log("성공:", req)
      //localStorage.setItem('Authorization', response.jwttoken);
      // response.setHeader
    })
    .catch((error) => {
      console.error("실패:", error)
    })
  // // .then(response => response.json())
  // .then(response => {
  // if (response.jwttoken) {

  // }
  // })
  // console.log("payload:", payload)
  console.log("username, passowrd:", username, password)
  console.log("JSON.stringify(req):", JSON.stringify(req))
  console.log("Login data upload succeed")
  // createToken()
}

formData.addEventListener("submit", login)

// onload.createToken()
function createToken(event) {
  // event.preventDefault()
  console.log("나 여기까지 왔니????????????????????")
    let toekn = sessionStorage.getItem("Authorization")
    fetch("/api/token", {
        method: "GET",
        headers: {
          "Content-type": "application/json",
          "Authorization" : toekn
        },
  
      })
      console.log("여기는????????????????????????????????")
      // console.log(Headers.getItem(Authorization))
  }

  // window.addEventListener("onload", createToken)



  





// fetch('http://localhost:8000/login/', {
//   method: 'POST',
//   headers: {
//       'Content-Type': 'application/json',
//   },
//   body: JSON.stringify({
//     'id': 'kim',
//     'password': '1234'
//   })
// })
// .then(response => response.json())
// .then(response => {
//   if (response.token) {
//     localStorage.setItem('wtw-token', response.token);
//   }
// })

// 여기서 부터 내가 원래 작성해 놨던 부분 시작
// const username = document.getElementById("username"),
//   password = document.getElementById("password")
// // loginBtn = document.getElementById("loginBtn")
// //   form = document.getElementById("submit-form")

// const formData = document.getElementById("submit-form")

// function login(event) {
//   event.preventDefault()
//   // const payload = new FormData(formData)
//   const req = {
//     username: username.value,
//     password: password.value,
//   }
//   console.log(req)
//   console.log(JSON.stringify(req))
//   fetch("/login", {
//     method: "POST",
//     headers: {
//       "Content-type": "application/json",
//     },
//     body: JSON.stringify(req),
//   })
//     .then((Response) => Response.text())
//     .then((req) => {
//       console.log("성공:", req)
//     })
//     .catch((error) => {
//       console.error("실패:", error)
//     })
//   // console.log("payload:", payload)
//   console.log("username, passowrd:", username, password)
//   console.log("JSON.stringify(req):", JSON.stringify(req))
//   console.log("Login data upload succeed")
// }

// formData.addEventListener("submit", login)
// 여기서 부터 내가 원래 작성했던 부분 끝
