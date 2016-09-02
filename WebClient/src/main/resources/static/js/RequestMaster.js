var RequestMaster = {
    
    request : null,
    
    /*
    The data recived in response.
    */
    data : null,
    
    sendRequest : function(data_in, executable){
        $.ajax({
            method: "GET",
            url : "/service/crawler",
            data: {
                "category":data_in
            },
            success: function(data){
                RequestMaster.data = data.result;
                executable.execute(data.result);
            }
        });
    },
    
    setData : function(categories){
        data = "";
        categories.forEach(function(category){
            data +=","+category;
        });
        return data.substring(1);
    }
};