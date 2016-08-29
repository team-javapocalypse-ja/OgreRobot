var Executable = {
    
    bookDataListExecutable : {
        execute : function(data){
            Object.keys(data).forEach(function(key){
                offers = data[key];
                if(isNaN(offers)){
                    offers.forEach(function(element){
                        ViewMaster.addrowFromBookData(element);          
                    });
                }
            });
        }    
    }
};