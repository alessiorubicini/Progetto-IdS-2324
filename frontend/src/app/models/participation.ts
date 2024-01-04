import {User} from "./user";
import {City} from "./city";
import {Role} from "./role";

export interface Participation {
	user: User;
	city: City;
	role: Role;
}
