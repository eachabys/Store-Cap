const returnsForm = document.getElementById('returns-form')
let returnsOrderid = document.getElementById('returns-orderid')


const cookieArr = document.cookie.split("=")
const user_id = cookieArr[1];

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/orders'
async function getOrder() {
    //console.log(returnsOrderid.value)
    const response = await fetch(`${baseUrl}/order/${returnsOrderid.value}`, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data=>{
            console.log(data);
            console.log(returnsOrderid.value);
            console.log(data.orderid);
        if ((data.userDto.id == user_id)&&(typeof data.orderid != 'undefined')) {
            populateOrder(data)
            .catch(err => console.error(err.message))
        }else{
            //clean orderdetails clean and alert
            alert('Check Order Id and your permissions to view it.');
          }
        })
}
document.getElementById('viewdetails').addEventListener('click', getOrder);


const populateOrder = (obj) => {
    let displayElement = document.getElementById('orderdetails');
    
    let content = '';
  
    for (let key in obj) {
        content += key + ': ' + obj[key] +';';
    }
    //console.log("haha ya kushu "+ content ); //to display content
    displayElement.value = content;
}
async function deleteOrder() {
    await fetch(`${baseUrl}/delete/${returnsOrderid.value}`, {
        method: "DELETE",
        headers: headers

    })
    .catch(err => console.error(err.message))
    .then(alert("Order Deleted"))
}
