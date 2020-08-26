let update = (state = [], action) => {
    switch (action.type) {
        case 'UPDATE':
            return [
                ...state,
                {
                    value: state.length++
                }
            ]
        default:
            return state
    }
}

export default update
