package ee.valiit.rainaiback.business;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("admin"),
    CUSTOMER("customer");

    private final String roleName;

    Role(String roleName){
        this.roleName = roleName;
    }

    public String getRoleName(){
        return roleName;
    }


}
