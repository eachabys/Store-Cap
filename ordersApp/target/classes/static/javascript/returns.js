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
    let displayElement = document.getElementById('orderdetails');

    let content = '';

    for (let key in obj) {
        content += key + ': ' + obj[key] + ';';
    }
    displayElement.value = content;
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
                .catch(err => console.error(err.message))
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

