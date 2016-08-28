var Executable = {
    
    bookDataListExecutable : {
        execute : function(data){
            data.forEach(function(element){
                ViewMaster.addrowFromBookData(element);          
            });
        }    
    }
};