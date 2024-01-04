import {Participation} from "./participation";

export interface UserDTO {
	id: number;
	username: string;
	roles: Participation[];
}
