function toggle(event) {
    var blur = document.getElementById("blur");
    blur.classList.toggle("active");
    var popup = document.getElementById("popup");
    popup.classList.toggle("active");
    event.preventDefault();
}
function validateForm() {
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var number = document.getElementById("number").value;
    var id = document.getElementById("id").value;
  
    if (name === "") {
        alert("Name is required");
        return false;
    }
    
    if (number.search(/[0-9]{10}$/)!=0) {
        alert("Enter a valid 10-digit number");
        return false;
    }
  
    if (email === "") {
        alert("Enter a valid email");
        return false;
    } else if (!email.includes("@")) {
        alert("Invalid Email address");
        return false;
    }
  
    if (id === "") {
        alert("ID should be filled out");
        return false;
    }
  
    return true;
}

function AddData() {

    document.getElementById('Update').style.display='none';
    if (validateForm()) {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var email = document.getElementById("email").value;
        var number = document.getElementById("number").value;
      
        var employeeList;
        if (localStorage.getItem("employeeList") === null) {
            employeeList = [];
        } else {
            employeeList = JSON.parse(localStorage.getItem("employeeList"));
        }
      
        employeeList.push({
            id: id,
            name: name,
            email: email,
            number: number
        });
      
        localStorage.setItem("employeeList", JSON.stringify(employeeList));
        showData();
      
        document.getElementById("id").value = "";
        document.getElementById("name").value = "";
        document.getElementById("email").value = "";
        document.getElementById("number").value = "";
    }
}

function showData() {
    var employeeList;
    if (localStorage.getItem("employeeList") === null) {
        employeeList = [];
    } else {
        employeeList = JSON.parse(localStorage.getItem("employeeList"));
    }
  
    var html = "";
    employeeList.forEach(function (element, index) {
        html += "<tr>";
        html += "<td>" + element.id + "</td>";
        html += "<td>" + element.name + "</td>";
        html += "<td>" + element.email + "</td>";
        html += "<td>" + element.number + "</td>";
        html +=
            '<td><button onclick="deleteData(' +
            index +
            ')" class="btn btn-primary">Delete</button>   <button onclick="updateData(' +
            index +
            ')" class="btn btn-primary">Edit</button> </td>';
        html += "</tr>";
    });
  
    document.querySelector("#curdTable tbody").innerHTML = html;
}

window.onload = showData();


function deleteData(index){

    var employeeList;
    if (localStorage.getItem("employeeList") === null) {
        employeeList = [];
    } else {
        employeeList = JSON.parse(localStorage.getItem("employeeList"));
    }
    
    employeeList.splice(index,1);
    localStorage.setItem("employeeList",JSON.stringify(employeeList));
    showData();
}

function updateData(index){
    document.getElementById("Submit").style.display="none";
    document.getElementById("Update").style.display="block";
    var popup=document.getElementById("popup");
    popup.classList.add("active");
    var blur =document.getElementById("blur");
    blur.classList.add("active");
    var employeeList;
    if (localStorage.getItem("employeeList") === null) {
        employeeList = [];
    } else {
        employeeList = JSON.parse(localStorage.getItem("employeeList"));
    }
 document.getElementById("id").value=employeeList[index].id;

 document.getElementById("name").value=employeeList[index].name;

 document.getElementById("email").value=employeeList[index].email;

 document.getElementById("number").value=employeeList[index].number;

 document.getElementById("Update").onclick=function(){
    if(validateForm()==true){
        employeeList[index].id=document.getElementById("id").value;
        employeeList[index].name=document.getElementById("name").value;
        employeeList[index].email=document.getElementById("email").value;
        employeeList[index].number=document.getElementById("number").value;
        localStorage.setItem("employeeList",JSON.stringify(employeeList));
        showData();
        document.getElementById("id").value = "";
        document.getElementById("name").value = "";
        document.getElementById("email").value = "";
        document.getElementById("number").value = "";

        document.getElementById("Submit").style.display="block";
    document.getElementById("Update").style.display="none";
    }
 }
 
}
function deleteAllData(){
    var employeeList;
    if (localStorage.getItem("employeeList") === null) {
        employeeList = [];
    } else {
        employeeList = JSON.parse(localStorage.getItem("employeeList"));
    }
    localStorage.clear();
    showData();
}