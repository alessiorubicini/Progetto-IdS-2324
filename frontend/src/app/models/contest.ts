export interface Contest {
	id?: number;
	title: string;
	description: string;
	publicationDate: Date;
	closingDate: Date;
	authorId: number;
	cityId: number;
	winnerId?: number;
}
