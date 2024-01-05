import {Participation} from "./participation";

export interface UserInfo {
	id: number;
	username: string;
	roles: Participation[];
}
