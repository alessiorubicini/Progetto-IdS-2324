import { City } from "./city";
import { Content } from "./content";

export interface Point {
	id: number;
	name: string;
	city: City;
	contents: Content[];
}