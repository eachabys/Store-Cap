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
    let displayElementnamedetail = document.getElementById('namedetails');
    //let displayElementlastnamedetail = document.getElementById('lastnamedetails');
    //let displayElementcitydetail = document.getElementById('citydetails');
    //let displayElementstatedetail = document.getElementById('statedetails');
    //let displayElementzipdetail = document.getElementById('zipdetails');
    //let displayElementregiondetail = document.getElementById('regiondetails');

    let content = '';

    for (let key in obj) {
        content += key + ': ' + obj[key] + ';';
    }
    //console.log("he llooo                 "+content);
    const contentdetail= content
    const contentdetail1=contentdetail.split(';');
    const namedetail1=contentdetail1[1];
    console.log(namedetail1)
    //const namedetail=namedetail1.split(':')[1];
    //const lastnamedetail1=contentdetail[3];
    //const lastnamedetail=lastnamedetail1.split(':')[1];

    //const citydetail1=contentdetail[6];
    //const citydetail=citydetail1.split(':')[1];
    //const statedetail1=contentdetail[7];
    //const statedetail=statedetail1.split(':')[1];
    //const zipdetail1=contentdetail[8];
    //const zipdetail=zipdetail1.split(':')[1];
   // const regiondetail1=contentdetail[9];
    //const regiondetail=regiondetail1.split(':')[1];
   
    //displayElementnamedetail.value = namedetail;
    //displayElementlastnamedetail.value = lastnamedetail;
    //displayElementcitydetail.value = citydetail;
   // displayElementstatedetail.value = statedetail;
    //displayElementzipdetail.value = zipdetail;
   //displayElementregiondetail.value = regiondetail;
 

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