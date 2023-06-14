const returnsForm = document.getElementById('returns-form')
let returnsOrderid = document.getElementById('returns-orderid')
const dropdown = document.getElementById('returnid');


const cookieArr = document.cookie.split("=")
const user_id = cookieArr[1];

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/orders'


const populateOrder = (obj) => {
    console.log(obj);
    document.getElementById('namedetails').value = obj.name;
    document.getElementById('lastnamedetails').value = obj.lastname;
    document.getElementById('citydetails').value = obj.city;
    document.getElementById('statedetails').value = obj.state;
    document.getElementById('zipdetails').value = obj.zip;
    document.getElementById('regiondetails').value = obj.region;

    let content = '';

    for (let key in obj) {
        content += key + ': ' + obj[key] + ';';
    }



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

selectOrder();