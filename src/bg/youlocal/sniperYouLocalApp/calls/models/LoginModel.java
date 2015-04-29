package bg.youlocal.sniperYouLocalApp.calls.models;

import bg.youlocal.sniperYouLocalApp.calls.constants.CallsConstants;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by sniper on 12/30/14.
 */
public class LoginModel implements Serializable {

    @SerializedName(CallsConstants.RADIUS)
    private int radius;
    @SerializedName(CallsConstants.NAME)
    private String name;
    @SerializedName(CallsConstants.SUCCESS)
    private String success;
    @SerializedName(CallsConstants.GENDER)
    private int gender;
    @SerializedName(CallsConstants.ABOUT_ME)
    private String aboutMe;
    @SerializedName(CallsConstants.AGES)
    private int ages;
    @SerializedName(CallsConstants.FULL_NAME)
    private String fullName;
    @SerializedName(CallsConstants.LONGITUDE)
    private double longitude;
    @SerializedName(CallsConstants.LATITUDE)
    private double latitude;
    @SerializedName(CallsConstants.LAST_UPDATE_DATE)
    private String lastUpdateDate;
    @SerializedName(CallsConstants.TOKEN)
    private String token;
    @SerializedName(CallsConstants.BIRTHDAY)
    private String birthday;
    @SerializedName(CallsConstants.LOCATION_ID)
    private String locationId;
    @SerializedName(CallsConstants.BIRTHDAY_PUBLIC)
    private String birthdayPublic;
    @SerializedName(CallsConstants.PHONE_NUMBER)
    private String phoneNumber;
    @SerializedName(CallsConstants.AVATAR_ORIGINAL)
    private String avatarOriginal;
    @SerializedName(CallsConstants.EMAIL)
    private String email;
    @SerializedName(CallsConstants.USER_ID)
    private String userId;
    @SerializedName(CallsConstants.AVATAR)
    private String avatar;

    public LoginModel(){}
    public LoginModel(JSONObject json){
        parseJSONtoLoginModel(json);
    }

    public int getRadius() {
        return radius;
    }

    public String getName() {
        return name;
    }

    public String getSuccess() {
        return success;
    }

    public int getGender() {
        return gender;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public int getAges() {
        return ages;
    }

    public String getFullName() {
        return fullName;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public String getToken() {
        return token;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getBirthdayPublic() {
        return birthdayPublic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvatarOriginal() {
        return avatarOriginal;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getUserId() {
        return userId;
    }

    private void parseJSONtoLoginModel(JSONObject json){
            radius = ((json.isNull(CallsConstants.RADIUS)) ? 0 : (json.optInt(CallsConstants.RADIUS)));
            gender = ((json.isNull(CallsConstants.GENDER)) ? 0 : (json.optInt(CallsConstants.GENDER)));
            latitude = ((json.isNull(CallsConstants.LATITUDE)) ? Double.NaN : Double.parseDouble(json.optString(CallsConstants.LATITUDE)));
            longitude = ((json.isNull(CallsConstants.LONGITUDE)) ? Double.NaN : Double.parseDouble(json.optString(CallsConstants.LONGITUDE)));
            success = ((json.isNull(CallsConstants.SUCCESS)) ? CallsConstants.EMPTY : json.optString(CallsConstants.SUCCESS));
            ages = ((json.isNull(CallsConstants.AGES)) ? 1 : (json.optInt(CallsConstants.AGES)));

            name = ((json.isNull(CallsConstants.NAME)) ? CallsConstants.EMPTY : (json.optString(CallsConstants.NAME)));
            aboutMe = ((json.isNull(CallsConstants.ABOUT_ME)) ? CallsConstants.EMPTY : (json.optString(CallsConstants.ABOUT_ME)));
            fullName = ((json.isNull(CallsConstants.FULL_NAME)) ? CallsConstants.EMPTY : (json.optString(CallsConstants.FULL_NAME)));

            lastUpdateDate = ((json.isNull(CallsConstants.LAST_UPDATE_DATE)) ? CallsConstants.EMPTY : json.optString(CallsConstants.LAST_UPDATE_DATE));
            token = ((json.isNull(CallsConstants.TOKEN)) ? CallsConstants.EMPTY : json.optString(CallsConstants.TOKEN));
            birthday = ((json.isNull(CallsConstants.BIRTHDAY)) ? CallsConstants.EMPTY : json.optString(CallsConstants.BIRTHDAY));
            locationId = ((json.isNull(CallsConstants.LOCATION_ID)) ? CallsConstants.EMPTY : json.optString(CallsConstants.LOCATION_ID));
            birthdayPublic = ((json.isNull(CallsConstants.BIRTHDAY_PUBLIC)) ? CallsConstants.EMPTY : json.optString(CallsConstants.BIRTHDAY_PUBLIC));
            phoneNumber = ((json.isNull(CallsConstants.PHONE_NUMBER)) ? CallsConstants.EMPTY : json.optString((CallsConstants.PHONE_NUMBER)));
            avatarOriginal = ((json.isNull(CallsConstants.AVATAR_ORIGINAL)) ? CallsConstants.EMPTY : json.optString(CallsConstants.AVATAR_ORIGINAL));
            email = ((json.isNull(CallsConstants.EMAIL)) ? CallsConstants.EMPTY : json.optString(CallsConstants.EMAIL));
            userId = ((json.isNull(CallsConstants.USER_ID)) ? CallsConstants.EMPTY : json.optString(CallsConstants.USER_ID));
            avatar = ((json.isNull(CallsConstants.AVATAR)) ? CallsConstants.EMPTY : (json.optString(CallsConstants.AVATAR)));
    }
    @Override
    public String toString() {
        return "LoginModel{" +
                "radius='" + radius + '\'' +
                ", name='" + name + '\'' +
                ", success='" + success + '\'' +
                ", gender='" + gender + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", ages='" + ages + '\'' +
                ", fullName='" + fullName + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", lastUpdateDate='" + lastUpdateDate + '\'' +
                ", token='" + token + '\'' +
                ", birthday='" + birthday + '\'' +
                ", locationId='" + locationId + '\'' +
                ", birthday_public='" + birthdayPublic + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", avatarOriginal='" + avatarOriginal + '\'' +
                ", email='" + email + '\'' +
                ", userId='" + userId + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
