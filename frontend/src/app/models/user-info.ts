import {Participation} from "./participation";

export interface UserInfo {
	id?: number;
	name: string;
	surname: string;
	username: string;
	fiscalCode: string;
	email: string;
	roles: Participation[];
}
