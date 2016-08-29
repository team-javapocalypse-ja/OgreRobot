var ViewMaster = {
    
    table : null,
    
    newTableHtml : function(){
        return "<table id='newTable'>" 
                    + "<tr>"
                        +"<th>Title</th>" 
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
    
    newRow : function(title, author, price){
        return    "\<tr>" // without \ it will be print a NaN, no idea why
                    +"<td>"+title+"</td>" 
                    +"<td>"+title+"</td>" 
                    +"<td>"+title+"</td>" 
                + "</tr>";
    },
    addrowFromBookData : function(data){
        ViewMaster.addRow(data.title, data.author, data.price);
    },
    addRow : function(title, author, price){
        id = ViewMaster.table.attr("id");
        $("#newTable tr:last").after(ViewMaster.newRow(title, author, price));
    },
    
    addCheckBoxList : function(theList, divId){
        _div = $("#"+divId);
        theList.forEach(
            function(category){
                ViewMaster.addCheckBox(category, _div);
            }
        );
        
        _div.find('input').click(function(){
            EBooksCategory.addToProfile($(this).attr('value'));
        });
        
    },
    //	<input type="checkbox" name="vehicle" value="Bike"> I have a bike<br>
    addCheckBox : function(category, where){
        _checkbox = "\<input type='checkbox' "
            +"name='"+category+"' value='"+category+"' >" 
            +" " + category;
        where.append(_checkbox);
    }
    
    
};