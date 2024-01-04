import { City } from "./city";
import { Content } from "./content";
import { User } from "./user";

export interface Contest {
	id: number;
	title: string;
	description: string;
	publicationDate: Date;
	closingDate: Date;
	authorId: number;
	cityId: number;
	winnerId: number;
}
