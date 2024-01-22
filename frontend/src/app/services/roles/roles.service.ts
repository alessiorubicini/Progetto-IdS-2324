import {Injectable} from '@angular/core';
import {Participation} from "../../models/participation";
import {UserInfo} from "../../models/user-info";
import {Role} from "../../models/role";

@Injectable({
	providedIn: 'root'
})
export class RolesService {

	constructor() { }

	public getUserInfo() : UserInfo | null {
		const userInfo = localStorage.getItem("user-info");
		return JSON.parse(userInfo!);
	}

	public getAllUserRoles() : Participation[] {
		return this.getUserInfo()!.participations;
	}

	public userRoleForCity(id: number) : Role | undefined {
		return this.getAllUserRoles().find(r => r.cityId == id)?.role;
	}

}
