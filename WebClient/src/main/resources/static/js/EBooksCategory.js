var EBooksCategory = {
    
    categoryList : ["EDUCATION", "ROMANS", "CRIMINAL", "BIOGRAPHY", "SCIENCE"],

    profile : [],
    
    resetList : function(){
      EBooksCategory.profile=[];  
    },
    
    addToProfile : function(category){
        EBooksCategory.profile.push(category);
    }
    
}