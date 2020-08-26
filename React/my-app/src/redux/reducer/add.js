let add = (state = [], action) => {
    switch (action.type) {
        case 'ADD':
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

export default add
