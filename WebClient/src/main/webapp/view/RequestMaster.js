var RequestMaster = {
    
    request : null,
    
    /*
    The data recived in response.
    */
    data : null,
    
    sendRequest : function(data_in, executable){
        $.ajax({
            method: "GET",
            url : "/service/home",
            data: data_in,
            success: function(data){
                RequestMaster.data = data;
                executable.execute(data);
            }
        });
    },
    
    setData : function(category){
        return {
            "category":category
        }
    }
};