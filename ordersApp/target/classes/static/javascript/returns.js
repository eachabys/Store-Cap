const returnsForm = document.getElementById('returns-form')
let returnsOrderid = document.getElementById('returns-orderid')
const dropdown = document.getElementById('returnid');
const dropdown2 = document.getElementById('quantity-id');


const cookieArr = document.cookie.split("=")
const user_id = cookieArr[1];

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/orders'


const populateOrder = (obj) => {
    let displayElementdatedetail = document.getElementById('datedetails');
    let displayElementproductdetail = document.getElementById('productdetails');
    let displayElementquantitydetail = document.getElementById('quantitydetails');
    let displayElementsaledetail = document.getElementById('saledetails');
    let displayElementreturniddetail = document.getElementById('returniddetails');
    let displayElementreturnquantitydetail = document.getElementById('returnquantitydetails');
    let displayElementreturnamountdetail = document.getElementById('returnamountdetails');

    let content = '';

    for (let key in obj) {
        content += key + ': ' + obj[key] + ';';
    }
    console.log(content);
    const contentdetail= content.split(';');
    const productdetail1=contentdetail[4];
    const productdetail=productdetail1.split(':')[1];
    const datedetail1=contentdetail[2];
    const datedetail=datedetail1.split(':')[1];
    const quantitydetail1=contentdetail[11];
    const quantitydetail=quantitydetail1.split(':')[1];
    const saledetail1=contentdetail[10];
    const saledetail=saledetail1.split(':')[1];
    const returniddetail1=contentdetail[14];
    const returniddetail=returniddetail1.split(':')[1];
    const returnquantitydetail1=contentdetail[16];
    const returnquantitydetail=returnquantitydetail1.split(':')[1];
    const returnamountdetail1=contentdetail[15];
    const returnamountdetail=returnamountdetail1.split(':')[1];

    displayElementdatedetail.value = datedetail;
    displayElementproductdetail.value = productdetail;
    displayElementsaledetail.value = saledetail;
    displayElementquantitydetail.value = quantitydetail;
    displayElementreturniddetail.value = returniddetail;
    displayElementreturnquantitydetail.value = returnquantitydetail;
    displayElementreturnamountdetail.value = returnamountdetail;
    
    dropdown2.innerHTML = "";
    for(let i = 1; i <= obj.quantity; i++) {
        const option = document.createElement('option');
        option.value = i;
        option.text = i;
        dropdown2.add(option);
    }
}

async function deleteOrder() {
    await fetch(`${baseUrl}/delete/${dropdown.value}`, {
        method: "DELETE",
        headers: headers

    })
    .catch(err => console.error(err.message))
    .then(alert("Order Deleted"))
}
async function selectOrder() {
    const response = await fetch(`${baseUrl}/user/${user_id}`, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => {
            const dropdown = document.getElementById('returnid');
            data.forEach(item => {
                const option = document.createElement('option');
                option.value = item.orderid;
                option.text = item.orderid;
                dropdown.add(option);
            });
        })
        .catch(error => console.error('Error:', error));
}
async function handleDropdownChange(event) {
    const selectedOptionValue = event.target.value;
    try {
        const response = await fetch(`${baseUrl}/order/${selectedOptionValue}`, {
            method: "GET",
            headers: headers
        })
            .then(res => res.json())
            .then(data => {
                populateOrder(data)
            //    .catch(err => console.error(err.message))
            })

    } catch (error) {
        console.error('Error:', error);
    }
}

dropdown.addEventListener('change', handleDropdownChange);

async function submitReturn() {
    console.log(dropdown2.value);
    console.log(dropdown.value);
    const response = await fetch(`${baseUrl}/return/${dropdown.value}/${dropdown2.value}`, {
        method: "PUT",
        headers: headers
    })
}
selectOrder();

