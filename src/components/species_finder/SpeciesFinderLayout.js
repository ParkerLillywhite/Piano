import React from "react";
import { SearchBar, RecentPosts } from './index';
import { Layout } from "../layout";

const SpeciesFinderLayout = () => {
    return(
        <Layout>
            <SearchBar />
            <RecentPosts />
        </Layout>
    )
}

export default SpeciesFinderLayout;