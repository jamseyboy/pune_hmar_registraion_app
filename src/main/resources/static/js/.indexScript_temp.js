
 async function getUserAddressDetails(url){

    const response = await fetch(url);
    const data = await response.json();
    console.log("The Data",data)
    return data;

}

function flattenJSON(obj, prefix=' ', depth =Infinity){

    let flattened = {};
    for(const key in obj){

        if(typeof obj[key] == 'object' && obj[key] !==null && depth>0){

            const nested = flattenJSON(obj[key], prefix+key+ '.', depth-1);
            flattened = {...flattened, ...nested};

        }else{
            flattened[prefix+key] = obj[key];
        }
    }
    return flattened;
}


function displayJSONInTable(json, table){

    const tbody = table.querySelector('tbody');
    for(const key in json){
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${key}</td>
            <td>${json[key]}</td>
        `;
        tbody.appendChild(tr);
    }
    
}



const userDetailsURL = 'http://localhost:8080/hsa/users'
const addressDetailsURL = 'http://localhost:8080/hsa/address'


let usersData;
let addressData;

getUserAddressDetails(userDetailsURL).then(jsonObject =>{
    console.log('Then Function')
    console.log(jsonObject);
    const usersflattenedJSON = flattenJSON(jsonObject, '', 2);
    console.log("Flattened", usersflattenedJSON);
    const usersjsonTable = document.getElementById('userjsonTable');
    console.log("userjsonTbale",usersjsonTable);
    displayJSONInTable(usersflattenedJSON, usersjsonTable);


}).catch(error =>{
    console.log('Error', error);
});


getUserAddressDetails(JSON.parse(addressDetailsURL)).then(jsonObject =>{
    console.log('Then Function')
    console.log(jsonObject);
    const addressFlattenedJSON = flattenJSON(jsonObject, '', 2);
    const addressjsonTable = document.getElementById('addressjsonTable');
    displayJSONInTable(addressFlattenedJSON, addressjsonTable);

}).catch(error =>{
    console.log('Error', error);
});

console.log(addressData);




