package bg.youlocal.sniperYouLocalApp.rest.model;

import com.google.gson.annotations.SerializedName;

//@Parcel
public class ApiResponse
{

    @SerializedName("detail")
    private String detail;


    public String getDetail()
    {
        return detail;
    }
}
