import {User} from "./user";
import {City} from "./city";
import {Role} from "./role";

export interface Participation {
	userId: number;
	city: City;
	role: Role;
}
