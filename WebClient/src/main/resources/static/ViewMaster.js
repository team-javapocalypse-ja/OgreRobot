var ViewMaster = {
    
    table : null,
    
    newTableHtml : function(){
        return "<table id='newTable'>" 
                    + "<tr>"
                        +"<th>Category</th>" 
                        +"<th>Title</th>" 
                        +"<th>Description</th>" 
                        +"<th>author</th>" 
                        +"<th>price</th>" 
                    + "</tr>" 
                + "</table>";
    },
    
    /**
    Creating the new table inside the divId
    **/
    newTable : function(divId){
        $("#"+divId).html(ViewMaster.newTableHtml());
        ViewMaster.table = $("#newTable");
    },
    
    newRow : function(category, title, description, author, price){
        return    "\<tr>" // without \ it will be print a NaN, no idea why
                    +"<td>"+category+"</td>" 
                    +"<td>"+title+"</td>" 
                    +"<td>"+description+"</td>" 
                    +"<td>"+author+"</td>" 
                    +"<td>"+price+"</td>" 
                + "</tr>";
    },
    addrowFromBookData : function(data){
        ViewMaster.addRow("", data.title, data.description, data.author, data.price, data.url);
    },
    addRow : function(category, title, description, author, price, url){
        id = ViewMaster.table.attr("id");
        description = description.replace("more...", "\<a href='"+url+"'> more </a>");
        $("#newTable tr:last").after(ViewMaster.newRow(category, title, description, author, price));
    },
    
    addCheckBoxList : function(theList, divId){
        _div = $("#"+divId);
        theList.forEach(
            function(category){
                ViewMaster.addCheckBox(category, _div);
            }
        );
    },
    //	<input type="checkbox" name="vehicle" value="Bike"> I have a bike<br>
    addCheckBox : function(category, where){
        _checkbox = "\<input type='checkbox' "
            +"name='"+category+"' value='"+category+"' >" 
            +" " + category;
        where.append(_checkbox);
    },
    
    newCategoryRow : function(category){
        ViewMaster.addRow(category, "", "", "", "");
    }
};