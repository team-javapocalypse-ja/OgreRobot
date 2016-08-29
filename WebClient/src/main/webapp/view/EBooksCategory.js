var EBooksCategory = {
    
    categoryList : ["art", "games", "education", "pets", "law"],
    
    profile : [],
    
    resetList : function(){
      EBooksCategory.profile=[];  
    },
    
    addToProfile : function(category){
        EBooksCategory.profile.push(category);
    }
    
}