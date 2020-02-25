var idSelected=undefined;

document.getElementById("dateFrom").value=new Date();
document.getElementById("dateTo").value=new Date();

var listPatiences = [
    {id:1, name:"Willian", lastname:"Ruiz Diaz",age:"32", blood_presure:"12-8",heart_rate:"12"},
    {id:2, name:"Mercedes", lastname:"Fonseca", age:"64", blood_presure:"12-8", heart_rate:"8"},
]
var printIcon = function(cell, formatterParams){ //plain text value
    return "<i class='fa fa-trash'></i>";
};
console.log("listPatience",listPatiences);
var tablePatiences = new Tabulator("#patience-list", {
    height:"500px",
    reactiveData:true,
    data:listPatiences, //set initial table data
    layout:"fitColumns",
    selectable:true,
    pagination:"local",
    paginationSize:6,
    paginationSizeSelector:[3, 6, 8, 10],
    rowClick:function(e, row){
        //e - the click event object
        //row - row component
        console.log("row",row);
        idSelected=row._row.data.id;
        console.log("idSelected",idSelected);
        document.getElementById("name").value=row._row.data.name;
        document.getElementById("age").value=row._row.data.age;
        document.getElementById("bloodPresure").value=row._row.data.blood_presure;
        document.getElementById("heartRate").value=row._row.data.heart_rate;
        row.toggleSelect(); //toggle row selected state on row click
    },
    columns:[
        {
            formatter: printIcon, width:40, align:"center", cellClick:function(e, cell){
            //alert("Printing row data for: " + cell.getRow().getData().name)
                deleteRow(cell);
        }
        },
        {title:"ID",field:'id'},
        {title:"Name", field:"name"},
        {title: "Lastname", field: "lastname"},
        {title:"Age", field:"age"},
        {title:"Blood Presure", field:"blood_presure"},
        {title:"Heart Rate", field:"heart_rate"}
    ],
});


tablePatiences.replaceData(listPatiences);

getAllPatiences();

function getAllPatiences(){
    axios.get('/patient')
  .then(function (response) {
    // handle success
    // {id:1, name:"Willian", lastname:"Ruiz Diaz",age:"32", blood_presure:"12-8",heart_rate:"12"},
    // {id:2, name:"Mercedes", lastname:"Fonseca", age:"64", blood_presure:"12-8", heart_rate:"8"},
    console.log(response);
  })
  .catch(function (error) {
    // handle error
    console.log(error);
  })
  .then(function () {
    // always executed
  });
}



function saveOrUpdateData(){
    console.log("saveOrUpdateData");



    var name=document.getElementById("name").value;
    var age=document.getElementById("age").value;
    var blood_presure=document.getElementById("bloodPresure").value;
    var heart_rate=document.getElementById("heartRate").value;

    //create new
    if(idSelected!=undefined){
        tablePatiences.updateData([{id:idSelected, name:name, age:age, blood_presure:blood_presure, heart_rate:heart_rate}]);
    }else{
        //we must calculate the id, that is the sum from the id's plus one
        var newId=calculateId();
        tablePatiences.addData([{id:newId, name:name, age:age, blood_presure:blood_presure, heart_rate:heart_rate}])
    }

    

}

function calculateId(){
    sum=0;
    tablePatiences.getData().forEach(function(value,index){
        sum=sum+value.id;
    });
    return sum+1;
}

function deleteRow(cell){
    tablePatiences.deleteRow(cell.getRow().getData().id);

    alert("Patience deleted: " + cell.getRow().getData().name)
}

function filterByName(){
    console.log("filterByName");
    var name=document.getElementById("patienceName").value;
    console.log(name);

    let found = tablePatiences.getData().find(element => element==name);
    console.log("found", found);
    var result=tablePatiences.getData().filter(function(value,index){
        return value.name==name; 
    });
    console.log("result",result);
    tablePatiences.setData(result);


}


function clearFilter(){
    document.getElementById("patienceName").value="";
    document.getElementById("dateFrom").value=new Date();
    document.getElementById("dateTo").value=new Date();
}
