import { City } from "./city";
import { Content } from "./content";

export interface Point {
	id: number;
	name: string;
	description: string;
	longitude?: number;
	latitude?: number;
	imageUrl: string;
	city: City;
	contents: Content[];
}


