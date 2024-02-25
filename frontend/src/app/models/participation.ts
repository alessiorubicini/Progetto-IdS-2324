import {Role} from "./role";

export interface Participation {
	id: {
		userId: number;
		cityId: number;
		role: Role;
	}
}
