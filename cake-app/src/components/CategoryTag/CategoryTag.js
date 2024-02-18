import React from 'react';

const CategoryTag = ({tag}) => {
    let tagClassName = '';
    if (tag === '水果') {
        tagClassName = "label-warning";
    } else if (tag === '蛋糕') {
        tagClassName = "label-danger";
    } else {
        tagClassName = "label-default";
    }

    return (
        <span className={`label ${tagClassName}`}>{tag}</span>
    );
}

export default CategoryTag;