var EBooksCategory = {
    
    categoryList : ["ROMANS", "EDUCATION", "CRIMINAL", "SCIENCE", "BIOGRAPHY"],

    profile : [],
    
    resetList : function(){
      EBooksCategory.profile=[];  
    },
    
    addToProfile : function(category){
        EBooksCategory.profile.push(category);
    }
    
}