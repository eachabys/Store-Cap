const returnsForm = document.getElementById('returns-form')
const returnsOrderid = document.getElementById('returns-orderid')
const noteForm = document.getElementById('note-form')
const noteCity=document.getElementById('note-city')


const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/returns'


const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        orderid: returnsOrderid.value,
    }

    const response = await fetch(`${baseUrl}/returns`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        //window.location.replace(responseArr[0])
        console.log(orderid,noteCity.value),
        console.log("I got here")
    }
}

returnsForm.addEventListener("submit", handleSubmit)