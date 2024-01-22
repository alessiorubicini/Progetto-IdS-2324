import {Content} from "./content";

export interface Point {
	id?: number;
	name: string;
	description: string;
	longitude?: number;
	latitude?: number;
	altitude?: number;
	imageUrl: string;
	cityId: number;
	contents?: Content[]
}


